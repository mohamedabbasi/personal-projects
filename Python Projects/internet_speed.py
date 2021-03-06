""" This code uses the speedtest module which can be downloaded through
    Typing "pip install speedtest-cli" in the terminal; p.s it might also
    Take a few seconds to run """

import speedtest
from tkinter import Tk, Label, mainloop

test = speedtest.Speedtest()
download_speed = test.download()
upload_speed = test.upload()
ping_result = test.results.ping

def speed_display():
    speedlabel = Label(root, text=f"Performing Speedtest...")
    speedlabel.config(font=("Consolas", 20))
    speedlabel.pack(side="top")


def display_stats():
    download = Label(root, text=f"Download speed: {round(download_speed / 1024 / 1024)} MBPs")
    upload = Label(root, text=f"Upload speed: {round(upload_speed / 1024 / 1024)} MBPs")
    ping = Label(root, text=f"Ping: {round(ping_result)} ms")

    download.config(font=("Consolas", 22))
    upload.config(font=("Consolas", 16))
    ping.config(font=("Consolas", 16))

    download.pack(side="top")
    upload.pack(side="top")
    ping.pack(side="top")

if __name__ == "__main__":
    root = Tk()
    root.geometry("350x300")
    root.title(f"WiFi Speedtest")
    speed_display()
    display_stats()
    mainloop()
