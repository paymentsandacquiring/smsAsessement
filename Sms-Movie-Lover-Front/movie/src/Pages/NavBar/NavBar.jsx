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
            activeCollection: "",
            activeLogin: "",
            activeRegister: ""
        }
    }
    componentWillMount(){
        if(this.props.data === "home"){
            this.highlightHome();
        }
        if(this.props.data === "list"){
            this.highlightList();
        }
        if(this.props.data === "rating"){
            this.highlightRating();
        }
        if(this.props.data === "collection"){
            this.highlightCollection();
        }
        if(this.props.data === "login"){
            this.highlightLogin();
        }
        if(this.props.data === "register"){
            this.highlightRegister();
        }
    }
    highlightHome(){
        this.setState({activeHome:"active"});
    }

    highlightList(){
        this.setState({activeList:"active"});
    }
    highlightRating(){
        this.setState({activeRating:"active"});
    }

    highlightCollection(){
        this.setState({activeCollection:"active"});
    }

    highlightLogin(){
        this.setState({activeLogin:"active"});
    }

    highlightRegister(){
        this.setState({activeRegister:"active"});
    }

    render(){
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <Link class={this.state.activeHome} to="">Home</Link>
                    <Link class={this.state.activeList} to="/list">Add Movie</Link>
                    <Link class={this.state.activeRating} to='/ratings'>Ratings</Link>
                    <Link class={this.state.activeCollection} to='/collection'>Collection</Link>
                    <Link class={this.state.activeLogin} to="/login">Login</Link>
                    <Link class={this.state.activeRegister} to="/register">Register</Link>
                    <input type="text" placeholder="Search.." />
                </div>
            </div>
        );
    }
}
export default NavBar;