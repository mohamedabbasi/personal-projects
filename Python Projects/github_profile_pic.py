import requests
from bs4 import BeautifulSoup as bs

github_user = input("Input Github username: ")
url = f"https://github.com/{github_user}"
r = requests.get(url)
soup = bs(r.content, "html.parser")

profile_picture = soup.find("img", {"alt": "Avatar"})["src"]
print(profile_picture)
