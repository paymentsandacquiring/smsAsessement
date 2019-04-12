import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';

class Home extends Component{
    render(){
        const active = "home";
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active}/>
                </div>
                <div class="watchListBody">
                    <p>
                         Welcome to the  SMS Movie Lover App, where you are able keep track of all the movie you have watched.
                    </p>
                </div>
            </div>
        );
    }
}
export default Home;