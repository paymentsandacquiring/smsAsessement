import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Redirect } from 'react-router-dom';
import NavBar from '../NavBar/NavBar';
import Home from '../Home/Home';
require('../Routes')

class Register extends Component{
    constructor() {
        super();
        this.state = {
            data: [
                {
                    "id": "firstName",
                    "value": "First Name",
                    "type": "text"
                },
                {
                    "id": "lastName",
                    "value": "Last Name",
                    "type": "text"
                },
                {
                    "id": "email",
                    "value": "Email",
                    "type": "text"
                },
                {
                    "id": "Gender",
                    "value": "gender",
                    "type": "radio"
                },
                {
                    "id": "password",
                    "value": "Password",
                    "type": "password"
                },
            ],
            ipAddress: "localhost",
            port: 8560
        }
    }
    clearForm = (event) => {
        event.preventDefault();

        document.getElementById('firstName').value = "";
        document.getElementById('lastName').value = "";
        document.getElementById('email').value = "";
        document.getElementById('gender').value = "";
        document.getElementById('password').value = "";
    };
   
    validateForm = (event) => {
        event.preventDefault();

        let firstName = document.getElementById('firstName').value
        let lastName = document.getElementById('lastName').value
        let email = document.getElementById('email').value
        let gender = document.getElementById('gender').value
        let password = document.getElementById('password').value

        if ((firstName === null) || (firstName === "")) {
            alert("Please enter first name");
        }
        else if ((lastName === null) || (lastName === "")) {
            alert("Please enter last name");
        }
        else if ((email === null) || (email === "")) {
            alert("Please email");
        }
        else if ((gender === null) || (gender === "")) {
            alert("Please select");
        }
        else if ((password === null) || (password === "")) {
            alert("Please enter password");
        }
        else {
           this.addMovieUser();            
        }
    };

   onClickRedirect = (event) => {
      this.addMovieUser();
       event.preventDefault(); 
       return (
        <Router>
        <div>
             <Route exact path="/home" component={Home} />
             <Redirect push to='/home'/>
        </div>
        </Router>
       )       
   }

    addMovieUser = () => {
        fetch("http://" + this.state.ipAddress + ":" + this.state.port + "/movie/addMovieUser?firstName=" + document.getElementById('firstName').value + "&lastName=" + document.getElementById('lastName').value + "")
            .then(response => response.json())
            .then(data => {
                switch (data.code) {
                    case "Saved":
                        console.log("Movie user added. Thank you");
                        break;
                    default:
                        console.log(data.code);
                }
            })
            .catch(function (error) {
                console.log("Error: " + error);
            })
    }
    render() {
        const active = "register";
        return (
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active} />
                </div>
                <div class="registerBody">
                    <p>
                        This is the register, where you can register.
                    </p>
                    <div align="center" class="App-header">
                        <form>
                            <h1>Register</h1>
                            <table >
                                <tr>
                                    <td>
                                        {this.state.data.map((rowData, i) => <FieldName data={rowData} />)}
                                    </td>
                                    <td>
                                        {this.state.data.map((rowData, i) => <FieldType data={rowData} />)}
                                    </td>
                                </tr>
                                <tr align="center">
                                    <td><button type="Reset" onClick={this.clearForm}>Clear</button></td>
                                    <td><button onClick={this.validateForm}>Submit</button></td>
                                </tr>
                            </table>
                        </form>
                    </div>

                </div>
            </div>
        );
    }
}
class FieldName extends Component {
    render() {
        return (
            <div>
                <tr><label class="labelColor">{this.props.data.value}</label></tr><br />
            </div>
        );
    }
}

class FieldType extends Component {
    constructor() {
        super();

        this.state = {
            movieName: "",
            movieYear: "",
            movieGenre: "",
            moviePublisher: "",
            movieRater: "",
        }
    }
    fieldValueWasEntered = (event) => {
        if (event.target.id === "") {
            let alphabet = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""];

            if (alphabet.includes(event.target.value.substring(event.target.value.length - 1).toLowerCase())) {
                this.setState({ [event.target.id]: event.target.value })
            }
        }
        else if ((event.target.id === "firstName") || (event.target.id === "lastName") || (event.target.id === "movieRater")) {
            let alphabet = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", ""];

            if (alphabet.includes(event.target.value.substring(event.target.value.length - 1).toLowerCase())) {
                this.setState({ [event.target.id]: event.target.value })
            }
        }
        else if (event.target.id === "password") {
            let alphabet = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " ", ""];

            if (alphabet.includes(event.target.value.substring(event.target.value.length - 1).toLowerCase())) {
                this.setState({ [event.target.id]: event.target.value })
            }
        }
        else {
            this.setState({ [event.target.id]: event.target.value })
        }
    }
    render() {
        return (
            <div>
                <tr>
                    <input id={this.props.data.id} type={this.props.data.type} value={this.state[this.props.data.id]} onChange={this.fieldValueWasEntered}></input>
                </tr><br />
            </div>
        );
    }
}
export default Register;