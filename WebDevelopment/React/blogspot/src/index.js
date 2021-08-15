import React from 'react';
import ReactDOM from 'react-dom';
import profile1 from './images/foto1.jpg';
import profile2 from './images/foto2.jpg';
import profile3 from './images/foto3.jpg';

const App = () =>{

  return(

    <div className='ui comments'>
      <div className='comment'>
        <a href="/" className='avatar'>
          <img src={profile1} alt="profile picture" />
        </a>
        <div className='content'>
          <a href="/" className='author'>
            Sarah
          </a>
          <div className='metadata'>
            <span className='date'>
              Today at 5:00PM
            </span>
          </div>
          <div className='text'>
            its' amazing
          </div>
        </div>
      </div>
    </div>
  )
}



ReactDOM.render(

  <App />,
  document.getElementById('root')
  
)