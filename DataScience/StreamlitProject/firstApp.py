#This is a simple App to show how we can quickly create a nice WebApp
#This App shows the closing price and the volume of Google in a period of time

import pandas as pd
import streamlit as st
import yfinance as yf #We need install this package for this WebbApp



#This the header of the WebApp, here we can write what we want to show in the App
st.write("""
         #Simple Stock Price App
         
         Shows the closing price and volume of google stock for ten years
         
         """)


tickerSymbol = 'GOOGL' #The Google symbol in Stock Market

tickerData = yf.Ticker(tickerSymbol)

tickerDF = tickerData.history(period= '1d', start = '2010-5-31', end = '2020-5-31')

#Create the closing price chart in the WebApp
st.line_chart(tickerDF.Close)
#Create the volumen chart in the WebApp
st.line_chart(tickerDF.Volume)