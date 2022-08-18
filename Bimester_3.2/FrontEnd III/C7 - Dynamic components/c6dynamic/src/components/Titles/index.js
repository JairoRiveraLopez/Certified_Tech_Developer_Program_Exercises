import React from 'react'
import styles from '../styles/titles.module.css'

const Title = ({id, title}) => {
    return (
        <>
        <h1 className={styles.Title} key={id}>{title}</h1>
        </>
    )
}
export default Title;