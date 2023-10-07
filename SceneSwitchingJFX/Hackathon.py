

import matplotlib.pyplot as plt
import pandas as pd
import time
from IPython.display import clear_output

#while True:
try:
        
        df = pd.read_excel("E:\\SceneSwitchingJFX\\Temp.xlsx")

       
        state_counts = df.groupby('STATE').size()
        xdata = state_counts.index
        ydata = state_counts.values
        clear_output(wait=True)
        plt.figure(figsize=(10, 6))  # Optional: Set the figure size
        plt.plot(xdata, ydata, marker='*', color='r', label='Number of Entries', linewidth=2, markersize=6)
        plt.xlabel("States")
        plt.ylabel("Number of Properties")
        plt.title("Total Number of Properties available for auction in each State")
        plt.xticks(rotation=60)
        plt.tight_layout()
        plt.grid(True)
        plt.show()
        #time.sleep(1)
        
except Exception as e:
       print("An error occurred:", str(e))
       time.sleep(5)
