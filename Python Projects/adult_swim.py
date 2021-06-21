import pyfiglet
import sys
import time

frame = pyfiglet.figlet_format("[ a s ]", font="Big")
for i in frame:
    sys.stdout.write(i)
    sys.stdout.flush
    time.sleep(0.01)
