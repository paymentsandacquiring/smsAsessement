import React from "react";
import NavBar from "../NavBar/NavBar";


class Login extends React.Component{
    render(){
        const active = "login"
        return(
            <div>
                <div class="topnav">
                    <NavBar data={active} />
                </div>
            </div>
        );
    };
}
export default Login;