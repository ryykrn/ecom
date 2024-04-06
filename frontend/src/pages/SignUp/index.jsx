import { useState } from "react";
import axios from "axios";

export function SignUp() {

    const [username, setUsername] = useState();
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [passwordRepeat, setPasswordRepeat] = useState();

    const onSubmit = (event) => {
        event.preventDefault();
        axios.post("/api/v1/users", {
            username,
            email,
            password
        })

    }

    return <div className="container">
        <div className="row justify-content-center">
            <div className="col-6">
                <form className="card" onSubmit={onSubmit}>
                    <div className="card-header">
                        <h1>Sign Up</h1>
                    </div>
                    <div className="card-body">
                        <div className="mb-3">
                            <label htmlFor="username" className="form-label">Username</label>
                            <input id="username" className="form-control" onInput={(event) => setUsername(event.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="email" className="form-label">E-mail</label>
                            <input id="email" className="form-control" onInput={(event) => setEmail(event.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input id="password" type="password" className="form-control" onInput={(event) => setPassword(event.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="passwordRepeat" className="form-label">Password Repeat</label>
                            <input id="passwordRepeat" type="password" className="form-control" onInput={(event) => setPasswordRepeat(event.target.value)} />
                        </div>
                        <button className="btn btn-primary" disabled={!password || password !== passwordRepeat} >Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
}