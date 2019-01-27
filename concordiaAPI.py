# TODO: Add parameter for fall/winter, etc semesters

import requests
import json

with open("config.json") as file:
    config = json.load(file)

user = config["apiUser"]
key = config["apiKey"]
url = "https://opendata.concordia.ca/API/v1/course/schedule/filter/*/COMP/*"

with open("courses.json", "w") as courses:
    r = requests.get(url, auth=(user, key))
    json.dump(r.json(), courses)
