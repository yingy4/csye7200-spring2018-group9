from datetime import datetime, timedelta
import time
from collections import namedtuple
import pandas as pd
import requests
import matplotlib.pyplot as p

def extract_weather_data(url, api_key, target_date, days):
    records = []
    i=0
    for _ in range(days):
        request = BASE_URL.format(API_KEY, target_date.strftime('%Y%m%d'))
        response = requests.get(request)
        if response.status_code == 200:
            i+=1
            print("success"+str(i))
            data = response.json()['history']['dailysummary'][0]
            records.append(DailySummary(
                date=target_date,
                meantempm=data['meantempm'],
                maxtempm=data['maxtempm'],
                mintempm=data['mintempm'],
                meanpressurem=data['meanpressurem'],
                maxpressurem=data['maxpressurem'],
                minpressurem=data['minpressurem'],
                meanhumidity=data['humidity'],
                maxhumidity=data['maxhumidity'],
                minhumidity=data['minhumidity'],
                rain=data['rain']))
        time.sleep(6)
        target_date += timedelta(days=1)
    return records

if __name__ == '__main__':
    # Every day this api can only get 500 data
    API_KEY = '791897507797ea42 '
    BASE_URL = "http://api.wunderground.com/api/{}/history_{}/q/UK/London.json"
    target_date = datetime(2018, 1, 1)
    features = ["date", "meantempm", "maxtempm", "mintempm",
                "meanpressurem", "maxpressurem", "minpressurem",
                "meanhumidity", "maxhumidity", "minhumidity",
                "rain"]
    DailySummary = namedtuple("DailySummary", features)
    # target date is the first day you want to start . The next parameter is the number of day you want to get
    extract_weather_data(BASE_URL,API_KEY,target_date,1)