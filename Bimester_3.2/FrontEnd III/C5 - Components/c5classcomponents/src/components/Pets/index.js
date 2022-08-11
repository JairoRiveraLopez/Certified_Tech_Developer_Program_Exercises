import React from 'react'
import './index.css'

const Pet = ({name, age, gender, kind, size}) => {
    return (
        <>
        <h4>Pet Information</h4>
        <ul>
            <li>Name: {name}</li>
            <li>Age: {age}</li>
            <li>Gender: {gender}</li>
            <li>Kind: {kind}</li>
            <li>Size: {size}</li>
        </ul>
        </>
    )
}
export default Pet;