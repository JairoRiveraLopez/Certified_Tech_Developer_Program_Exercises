import React from 'react'
import styles from './styles/cabecera.module.css'

export default function Cabecera({purchasedItems}) {
  return (
    <header className={`${styles.header}`}>
        <h1>Carrito de compras</h1>
        <p>Cantidad de productos  <span>{purchasedItems}</span></p>
    </header>
  )
}