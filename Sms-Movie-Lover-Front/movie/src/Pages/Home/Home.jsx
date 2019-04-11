import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';

class Home extends Component{
    render(){
        const activeHome = "active";
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar state={{activeHome:activeHome}}/>
                </div>
                <div class="watchListBody">
                    This is the Home
                </div>
            </div>
        );
    }
}
export default Home;