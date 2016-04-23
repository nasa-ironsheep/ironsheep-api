# import os
import requests
import json

from PIL import Image
from StringIO import StringIO
# from PIL import ImageFilter


class Grass:
    url = "https://api.nasa.gov/planetary/earth/imagery"
    lon = 100.75
    lat = 1.5
    date = "2014-02-01"
    cloud_score = True

    def __init__(self, **kwargs):
        for key, value in kwargs.items():
            getattr(self, key, value)

        with open("config.json") as json_file:
                json_data = json.load(json_file)
                for key, value in json_data.items():
                    if key == "api_key":
                        self.api_key = value

        self.params = {
                "lon": self.lon,
                "lat": self.lat,
                "date": self.date,
                "cloud_score": self.cloud_score,
                "api_key": self.api_key
                }
        self.create_image()

    def api(self):
        req = requests.get(self.url, params=self.params)
        data = json.loads(req.text)
        for key, value in data.items():
            if key == "url":
                return value

    def create_image(self):
        req = requests.get(self.api())
        im = Image.open(StringIO(req.content))
        # import pdb; pdb.set_trace()

if __name__ == "__main__":
    grass = Grass()
