import urllib
from bs4 import BeautifulSoup
import urllib.request


def get_weather(city):
    header = {
        'User-Agent':
        'Mozilla/5.0 (Windows NT 6.1; WOW64;rv:23.0) Gecko/20100101 Firefox/23.0'
    }
    website = "http://www.tianqi.com/" + city + ".html"
    req = urllib.request.Request(url=website, headers=header)
    page = urllib.request.urlopen(req)
    html = page.read()
    soup = BeautifulSoup(html.decode("utf-8"), "html.parser")
    nodes = soup.find_all('dd')
    tody_weather = ""
    for node in nodes:
        temp = node.get_text()
        if temp.find('[切换城市]'):
            temp = temp[:temp.find('[切换城市]')]
        tody_weather += temp
    weather_result = "".join(
        [s for s in tody_weather.splitlines(True) if s.strip()])
    return weather_result


def main():
    w = get_weather("wuhan")
    print(w)


if __name__ == "__main__":
    main()
