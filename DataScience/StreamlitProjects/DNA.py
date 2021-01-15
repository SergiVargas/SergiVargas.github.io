#This is a bioinformatic App
#Count the nucleotide composition of query DNA

import pandas as pd
import streamlit as st
import altair as alt
from PIL import Image

#First manipulate the logo with PIL library
logo = Image.open("Data\dna.png").resize((700,600)).rotate(90)


#Page Title
st.image(logo)

st.write("""
         # DNA Nucleotide Count Web App
         
         #### This app counts the nucleotide composition of query DNA!
         
         ***
         """)

#Page Text Box

st.header('Enter DNA sequence')

sequence = ">>> DNA Sequence\n\n\nGGAAAACAGAGTCGTACGTATAGCTATAGCGCATAGCTCTTTAACCCAGAGAGTGCAAAAAGGTGTGTCCTAGAAATTTGTGTTCGT"

#Show the sequence in the Web App, we can interact in the text_area

sequence = st.text_area("Sequence input. You can enter any other sequence.", sequence, height = 50)
sequence = sequence.splitlines()
sequence = sequence[1:]
sequence = "".join(sequence)

st.write("""
         ***
         """)

# Prints the DNA information
st.header('INPUT (DNA Query)')
sequence
st.header('OUTPUT (DNA Nucleotide Count)')

#Show as dictionary
st.subheader("1.Display as dictionary")

def DNA_count(sequence):
    
    data = dict([
        
        ('A', sequence.count('A')),
        ('T', sequence.count('T')),
        ('G', sequence.count('G')),
        ('C', sequence.count('C'))
    ])
    
    return data



X = DNA_count(sequence)

X_label = list(X)
X_values = list(X.values())

X
st.write("""
         ***
         """)


#Show as text
st.subheader("2. Display as text")
st.write('The are ' + str(X['A']) + ' adenine (A)')
st.write('The are ' + str(X['T']) + ' thymine (T)')
st.write('The are ' + str(X['G']) + ' guanine (G)')
st.write('The are ' + str(X['C']) + ' cytosine (C)')

st.write("""
         ***
         """)


# Show as Dataframe
st.subheader('3. Display as DataFrame')
df = pd.DataFrame.from_dict(X, orient = 'index')
df = df.rename({0: 'Count'}, axis = 'columns')
df.reset_index(inplace = True)
df = df.rename(columns = {'index': 'Nucleotide'})
st.write(df)

st.write("""
         
         ***
         """)


#Show as Bar Chart
st.subheader('4. Display as Bar Chart')

p = alt.Chart(df).mark_bar().encode(
    
    x = 'Nucleotide',
    y = 'Count'
)

p = p.properties(width = alt.Step(80))

st.write(p)

st.write("""
         
         ***
         """)








