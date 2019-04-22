import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Redirect } from 'react-router-dom';
import NavBar from '../NavBar/NavBar';
import Home from '../Home/Home';
require('../Routes')


class WatchList extends Component {
    constructor() {
        super();
        this.state = {
            data: [
                {
                    "id": "movieName",
                    "value": "Movie Name",
                    "type": "text"
                },
                {
                    "id": "movieYear",
                    "value": "Movie Year",
                    "type": "number"
                },
                {
                    "id": "movieGenre",
                    "value": "Genre",
                    "type": "text"
                },
                {
                    "id": "moviePublisher",
                    "value": "Publisher",
                    "type": "text"
                },
                // {
                //     "id": "movieRater",
                //     "value": "Rater",
                //     "type": "text"
                // },
            ],
            ipAddress: "localhost",
            port: 8560
        }
    }
    clearForm = (event) => {
        event.preventDefault();

        document.getElementById('movieName').value = "";
        document.getElementById('movieYear').value = "";
        document.getElementById('movieGenre').value = "";
        document.getElementById('moviePublisher').value = "";
        document.getElementById('movieRater').value = "";
    };
   
    validateForm = (event) => {
        event.preventDefault();

        let movieName = document.getElementById('movieName').value
        let movieYear = document.getElementById('movieYear').value
        let movieGenre = document.getElementById('movieGenre').value
        let moviePublisher = document.getElementById('moviePublisher').value
        let movieRater = document.getElementById('movieRater').value

        if ((movieName === null) || (movieName === "")) {
            alert("Please enter movie name");
        }
        else if ((movieYear === null) || (movieYear === "")) {
            alert("Please enter movie year");
        }
        else if ((movieGenre === null) || (movieGenre === "")) {
            alert("Please enter movie genre");
        }
        else if ((moviePublisher === null) || (moviePublisher === "")) {
            alert("Please enter movie publisher");
        }
        else if ((movieRater === null) || (movieRater === "")) {
            alert("Please enter movie rater");
        }
        else {
            // this.addMovieWithAllDetails();
            
        }
    };

   onClickRedirect = (event) => {
       this.addMovieWithAllDetails();
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

   addMovieWithAllDetails = () => {
    this.addMovie();
    this.addGenre();
    this.addPublisher();
   }
    addMovie = () => {
        fetch("http://" + this.state.ipAddress + ":" + this.state.port + "/movie/addMovie?movieName=" + document.getElementById('movieName').value + "&movieYear=" + document.getElementById('movieYear').value + "")
            .then(response => response.json())
            .then(data => {
                switch (data.code) {
                    case "Saved":
                        console.log("Movie added. Thank you");
                        break;
                    default:
                        console.log(data.code);
                }
            })
            .catch(function (error) {
                console.log("Error: " + error);
            })
    }
    addGenre = () => {
        fetch("http://" + this.state.ipAddress + ":" +this.state.port+ "/movie/addGenre?movieName=" + document.getElementById('movieName').value + "&movieYear=" + document.getElementById('movieYear').value + "&genreName=" + document.getElementById('movieGenre').value + "")
            .then(response => response.json())
            .then(data => {
                switch (data.code) {
                    case "Saved":
                        console.log("Genre added. Thank you");
                        break;
                    default:
                        console.log(data.code);
                }
            })
            .catch(function (error) {
                console.log("Error: " + error);
            })
    }
    addPublisher = () => {
        fetch("http://" + this.state.ipAddress + ":" +this.state.port+ "/movie/addPublisher?movieName=" + document.getElementById('movieName').value + "&movieYear=" + document.getElementById('movieYear').value + "&publisherName=" + document.getElementById('moviePublisher').value + "")
            .then(response => response.json())
            .then(data => {
                switch (data.code) {
                    case "Saved":
                        console.log("Publisher added. Thank you");
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
        const active = "list";
        return (
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active} />
                </div>
                <div class="watchListBody">
                    <p>
                        This is the watchList, where you can add a movie that you have watched.
                    </p>
                    <div align="center" class="App-header">
                        <form>
                            <h1>Add A Movie</h1>
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
                                    <td><button onClick={this.onClickRedirect}>Submit</button></td>
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
        if (event.target.id === "movieYear") {
            let alphabet = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""];

            if (alphabet.includes(event.target.value.substring(event.target.value.length - 1).toLowerCase())) {
                this.setState({ [event.target.id]: event.target.value })
            }
        }
        else if ((event.target.id === "movieGenre") || (event.target.id === "moviePublisher") || (event.target.id === "movieRater")) {
            let alphabet = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", ""];

            if (alphabet.includes(event.target.value.substring(event.target.value.length - 1).toLowerCase())) {
                this.setState({ [event.target.id]: event.target.value })
            }
        }
        else if (event.target.id === "movieName") {
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
export default WatchList;