# import os
import requests
import json

from PIL import Image
from StringIO import StringIO
# from PIL import ImageFilter


class Grass:
    api_url = "https://api.nasa.gov/planetary/earth/imagery"
    lon = 100.75
    lat = 1.5
    date = "2014-02-01"
    cloud = True

    def __init__(self, **kwargs):
        for key, value in kwargs.items():
            setattr(self, key, value)

        with open("config.json") as json_file:
                json_data = json.load(json_file)
                for key, value in json_data.items():
                    if key == "api_key":
                        self.api_key = value

        params = {
                "lon": self.lon,
                "lat": self.lat,
                "date": self.date,
                "cloud_score": self.cloud,
                "api_key": self.api_key
                }
        self.api(params)

    def api(self, params):
        req = requests.get(self.api_url, params=params)
        data = json.loads(req.content)
        for key, value in data.items():
            if key == "url" or key == "cloud_score":
                setattr(self, key, value)

    def create_image(self):
        req = requests.get(self.url)
        img = Image.open(StringIO(req.content))
        return img

    def grass(self):
        img = self.create_image()
        return 1.0

    def percent(self):
        level_grass = 1 - self.cloud_score
        # import pdb; pdb.set_trace()
        return self.grass()/level_grass


if __name__ == "__main__":
    grass = Grass()
    print grass.percent()
