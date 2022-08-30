import { useEffect, useState } from "react";

const Crono = () => {
    let [number, setNumber] = useState(0)
    let [status, setStatus] = useState("initialized")

    useEffect( () => {
        let interval;
        if(status === "started"){
            interval = setInterval(() => {
            setNumber(number + 1)
            }, 1000)
        }else{
            clearInterval(interval)
            setNumber(0)
        }
    }, [status, number])

    return (
        <>
        <h2>Crono App</h2>
        <p>{number}</p>
        <button onClick={() => setStatus("started")} >Start</button>
        <button onClick={() => setStatus("reset")} >Reset</button>
        </>
    )
}

export default Crono;
