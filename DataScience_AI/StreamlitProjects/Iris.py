import streamlit as st
import numpy as np
import pandas as pd
from PIL import Image
from sklearn import datasets
from sklearn.ensemble import RandomForestClassifier

#First manipulate the logo with PIL library
logo = Image.open("Data\iris.jpg").resize((700,600))


#Page Title
st.image(logo)

st.write("""
         
         # Iris Flower Prediction
         
         ### **Predicts the Iris flower type**
         """)


st.sidebar.header('Input Parameters')


def user_in_features():
    sepal_length = st.sidebar.slider('Sepal_lenght', 4.0,8.0,6.0)
    sepal_width = st.sidebar.slider('Sepal_width', 2.0, 5.0, 3.5)
    petal_length = st.sidebar.slider('Petal_lenght', 1.0,7.0,1.3)
    petal_width = st.sidebar.slider('Petal_width', 0.2,2.6,0.2)
    data = {
        'Sepal_length': sepal_length,
        'Sepal_width' : sepal_width,
        'Petal_length': petal_length,
        'Petal_width': petal_width}
    
    features = pd.DataFrame(data, index=[0])
    return features

df = user_in_features()

st.subheader('User Input parameters')

st.dataframe(df)

iris = datasets.load_iris()
X = iris.data
Y = iris.target

clf = RandomForestClassifier()
clf.fit(X,Y)


prediction = clf.predict(df)
prediction_proba = clf.predict_proba(df)

st.subheader('Class labels and their index number')
st.write(iris.target_names)

st.subheader('Prediction')
st.write(iris.target_names[prediction])

st.subheader('Prediction Probability')
st.write(prediction_proba)
