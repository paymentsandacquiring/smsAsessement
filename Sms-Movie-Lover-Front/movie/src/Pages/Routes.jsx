import React from "react";
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import Home from "./Home/Home";
import WatchList from "./WatchList/WatchList";
import Ratings from "./Ratings/Ratings";
import Collection from "./Collection/Collection";

class Routes extends React.Component{
    render(){
        return(
            <div>
                <Router>
                    <div>
                        <Route exact path="/" component={Home}/>
                        <Route path="/list" component={WatchList} />
                        <Route path="/home" component={Home} />
                        <Route path='/ratings' component={Ratings} />
                        <Route path='/collection' component={Collection} />
                    </div>
                </Router>
            </div>
        );
    }
}
export default Routes;