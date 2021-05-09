import React from 'react';

function Header(props){

    

    return(
      <div>
        <h3>{props.titulo}</h3>


        <h1>{props.numero}</h1>

     </div>
    );


}

export default Header;