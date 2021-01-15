#This is a simple App to show how We can create quickly a beatiful WebApp
#This App show the close price and volume of Google in a period of time

import pandas as pd
import streamlit as st
import yfinance as yf #We need install this package for this App



#This the header of WebApp, here we can write that we want to show in el App
st.write("""
         #Simple Stock Price App
         
         Shown are the stock closing price and volumen of Google Action in during ten years
         
         
         """)


tickerSymbol = 'GOOGL' #The symbol of Google in Stock Market

tickerData = yf.Ticker(tickerSymbol)

tickerDF = tickerData.history(period= '1d', start = '2010-5-31', end = '2020-5-31')
#Create the chart of closing price in WebApp
st.line_chart(tickerDF.Close)
#Create the chart of volumen in WebApp
st.line_chart(tickerDF.Volume)