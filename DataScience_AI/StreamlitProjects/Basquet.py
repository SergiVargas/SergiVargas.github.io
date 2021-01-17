import streamlit as st
import pandas as pd
import base64
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np
from PIL import Image


#First manipulate the logo with PIL library
logo = Image.open("Data\\basket.jpg").resize((600,500))


#Page Title
st.image(logo)



st.title('NBA Player Stats Explorer')

st.markdown("""

This app performs simple webscraping of NBA player stats data!
* **Data source:** [Basketball-reference.com](http://www.basketball.reference.com/).           
                       
""")

st.sidebar.header('User Input Features')
selected_year = st.sidebar.selectbox('Year of Competition',(list(reversed(range(1950, 2021)))))

# Web scraping of NBA Player stats

@st.cache
def load_data(year):
    url = "https://www.basketball-reference.com/leagues/NBA_" + str(year) + "_per_game"
    html = pd.read_html(url, header = 0)
    df = html[0]
    raw = df.drop(df[df.Age == 'Age'].index)
    raw = raw.fillna(0)
    playerstats = raw.drop(['Rk'], axis = 1)
    return playerstats
playerstats = load_data(selected_year)



#Team selection (sidebar)

sorted_unique_team = sorted(playerstats.Tm.unique())
selected_team = st.sidebar.multiselect('Team', sorted_unique_team, sorted_unique_team)



#Position selection (sidebar)

unique_pos = ['C', 'PF', 'SF', 'PG', 'SG']
selected_pos = st.sidebar.multiselect('Position', unique_pos, unique_pos)


#Filtering data

df_selected_team = playerstats[(playerstats.Tm.isin(selected_team))]



