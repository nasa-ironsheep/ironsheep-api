import requests
import json
import mimerender

from PIL import Image
from StringIO import StringIO
from datetime import date
from flask import Flask

mimerender = mimerender.FlaskMimeRender()

render_json = lambda **args: json.dumps(args)

app = Flask(__name__)

today = date.today()
api_url = "https://api.nasa.gov/planetary/earth/imagery"
lon = 100.75
lat = 1.5
cloud = True
api_key = "JNkasX49VZ8ygFComU3nBu97zhj4EBV2c0AEBnsV"
params = {}
url = ""
cloud_score = 0.1
date = ""

@app.route('/')
@app.route('/<float:lon>/<float:lat>')
@mimerender(
    default = 'json',
    json = render_json
)
def greet(lon, lat):
    req = requests.get(api_url, params={
            "lon": lon,
            "lat": lat,
            "date": today,
            "cloud_score": cloud,
            "api_key": api_key
            })
    data = json.loads(req.content)
    for key, value in data.items():
        if key == "url":
            url = value
        if key == "cloud_score":
            cloud_score = value
        if key == "date":
            date = value
    # return {'c':url}
    req2 = requests.get(url)
    img = Image.open(StringIO(req2.content))

    pix = img.load()
    green = 0
    for i in range(0, img.width):
        for j in range(0, img.height):
            if pix[i, j][0] < pix[i, j][1] and pix[i, j][2] < pix[i, j][1]:
                green += 1

    percent = float(green)/(img.width*img.height)

    params = {
            "grass": percent,
            "erro": cloud_score,
            "date": date
            }
    return params

if __name__ == "__main__":
    app.run(port=5000)
