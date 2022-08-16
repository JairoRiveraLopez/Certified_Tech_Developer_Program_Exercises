import React from 'react'
import styles from '../styles/titles.module.css'
import Title from '../Titles';

const Container = ( {titles} ) => {

    return (
        <div className={styles.Container}>
        {
            titles.map( (title) => <Title id={title.id} title={title.title}/> )
        } 
        </div>
    )
    };
    
    export default Container;