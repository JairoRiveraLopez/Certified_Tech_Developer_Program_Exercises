import React from 'react'


export default class Pizza extends React.Component {
    constructor(props) {
      super()
    }
    
    componentWillUnmount() {
      console.log("Se ha quitado la oferta del menu en el home");
  }

    render() {
      const {name, image} = this.props
  
      return (
        <div >
        <h2>{name}</h2>
        <img src={image} width = "100px" alt={name} />
        </div>
      )
    }
  
  }

