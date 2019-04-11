import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';


class Ratings extends Component{
    render(){
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar/>
                </div>
                <div class="watchListBody">
                    This is the Ratings Page
                </div>
            </div>
        );
    }
}
export default Ratings;