import { useEffect, useState } from "react";

const Stopwatch = () => {
    const [time, setTime] = useState(0);
    const [status, setStatus] = useState(false);

    useEffect(() => {
        let interval;
    if (status === "started") {
        interval = setInterval(() => {
        setTime((prevTime) => prevTime + 10);
        }, 10);
    } else if ("paused") {
        clearInterval(interval);
    }
    return () => clearInterval(interval);
    }, [status]);
    
    return (
    <div className="stopwatch">
        <div className="numbers">
            <span>{("0" + Math.floor((time / 60000) % 60)).slice(-2)}:</span>
            <span>{("0" + Math.floor((time / 1000) % 60)).slice(-2)}:</span>
            <span>{("0" + ((time / 10) % 100)).slice(-2)}</span>
        </div>
        <div className="buttons">
            <button onClick={() => setStatus("started")}>Start</button>
            <button onClick={() => setStatus("paused")}>Stop</button>
            <button onClick={() => setTime(0)}>Reset</button>
        </div> 
    </div>
    );
};

export default Stopwatch;
