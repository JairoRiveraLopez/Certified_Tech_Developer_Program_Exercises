import React from 'react'
import Pet from '../Pets';
import './index.css'

const Container = ( {pets} ) => {

return (
    <div className="container">
        <h2>DH Vet</h2>
    {
        pets.map( (pet) => <Pet name={pet.name} age={pet.age} gender={pet.gender} kind={pet.kind} size={pet.size}/> )
    } 
    </div>
)
};

export default Container;