import requests
import json

send_url = 'http://freegeoip.net/json'
r = requests.get(send_url)
j = json.loads(r.text)
lat = j['latitude']
lon = j['longitude']


from haversine import *

current = (lat, lon)
disaster_brian_head = (-115,38)
dist_brian_head = haversine(current, disaster_brian_head)
dist_brian_head = str(round(dist_brian_head))
print("You are " + dist_brian_head + " miles from the Brian Head, UT wildfire.")

disaster_esmeralda = (-80, 0)
dist_esmeralda = haversine(current, disaster_esmeralda)
dist_esmeralda = str(round(dist_esmeralda))
print("You are " + dist_esmeralda + " miles from the Esmeralda, Ecuador earthquake.")

disaster_teramo = (14,43)
dist_teramo = haversine(current, disaster_teramo)
dist_teramo = str(round(dist_teramo))
print("You are " + dist_teramo + " miles from the Teramo, Italy earthquake.")

disaster_bodrum = (27,39)
dist_bodrum = haversine(current, disaster_bodrum)
dist_bodrum = str(round(dist_bodrum))
print("You are " + dist_bodrum + " miles from the Bodrum, Turkey tsunami.")

disaster_panguna = (157,-8)
dist_panguna = haversine(current, disaster_panguna)
dist_panguna = str(round(dist_panguna))
print("You are " + dist_panguna + " miles from the Pamguna, Papua New Guinea earthquake.")


