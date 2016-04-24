import sys
import requests
import json

from PIL import Image
from StringIO import StringIO
from datetime import date


class Grass:
    api_url = "https://api.nasa.gov/planetary/earth/imagery"
    lon = 100.75
    lat = 1.5
    cloud = True

    def __init__(self, **kwargs):
        for key, value in kwargs.items():
            setattr(self, key, value)

        with open("config.json") as json_file:
                json_data = json.load(json_file)
                for key, value in json_data.items():
                    if key == "api_key":
                        self.api_key = value

        self.today = date.today()
        params = {
                "lon": self.lon,
                "lat": self.lat,
                "date": self.today,
                "cloud_score": self.cloud,
                "api_key": self.api_key
                }
        self.api(params)

    def api(self, params):
        req = requests.get(self.api_url, params=params)
        data = json.loads(req.content)
        for key, value in data.items():
            if key == "url" or key == "cloud_score" or key == "date":
                setattr(self, key, value)

    def create_image(self):
        req = requests.get(self.url)
        img = Image.open(StringIO(req.content))
        return img

    def grass(self):
        img = self.create_image()
        pix = img.load()
        green = 0
        for i in range(0, img.width):
            for j in range(0, img.height):
                if pix[i, j][0] < pix[i, j][1] and pix[i, j][2] < pix[i, j][1]:
                    green += 1

        percent = float(green)/(img.width*img.height)

        params = {
                "grass": percent,
                "erro": self.cloud_score,
                "date": self.date
                }
        return json.dumps(params)


if __name__ == "__main__":
    grass = Grass(lon=sys.argv[1], lat=sys.argv[2])
    #print grass.grass()
    try:
        file = open('green.json','w')   # Trying to create a new file or open one
        file.write(grass.grass())
        file.close()

    except:
        print('Something went wrong! Can\'t tell what?')
        sys.exit(0) # quit Python
