import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import './NavBar.css';

class NavBar extends Component{
    constructor(props){
        super(props);
        this.state={
            activeHome: "",
            activeList: "",
            activeRating: "",
            activeCollection: ""
        }
    }
    render(){
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <Link class={this.state.activeHome} to="">Home</Link>
                    <Link class={this.state.activeList} to="/list">Watch List</Link>
                    <Link class={this.state.activeRating} to='/ratings'>Ratings</Link>
                    <Link class={this.state.activeCollection} to='/collection'>Collection</Link>
                </div>
            </div>
        );
    }
}
export default NavBar;