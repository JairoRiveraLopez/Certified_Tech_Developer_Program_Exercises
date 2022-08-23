import React from 'react'
import {pizzaData} from '../Data/pizzaData'
import Pizza from './Pizza'

export default class Container extends React.Component {
    constructor(props) {
        super(props)
  
    this.state = {
        pizzas : [],
        estadoPedido : "¡Bienvenido!"
    }
}

    componentDidMount(){
        setTimeout(() => {
            console.log("Se montó el elemento");
            this.setState({
                pizzas : pizzaData,
                estadoPedido: "No has pedido ninguna pizza"
                
            });
        }, 2000);
    }

    componentDidUpdate(){
        console.log("Se actualizó el elemento");
    }

    hacerPedido = () =>{
        this.setState({
            pizzas: pizzaData,
            estadoPedido: "Has realizado un pedido."
        });
    }
    noQuieroPedir = () =>{
        this.setState({
            pizzas:[],
            estadoPedido: "¡Te extrañaremos! :("
        });
    }

    render() {
        return (
        <>
            <h4>{this.state.estadoPedido}</h4>
            {
                this.state.pizzas.map((pizza) => <Pizza key={(pizza.id)} name={pizza.name} image={pizza.image} />)
            }
            <button onClick={this.hacerPedido} >Hacer Pedido</button>
            <button onClick={this.noQuieroPedir} >No quiero hacer pedidos</button>
        </>
        )
    }
}