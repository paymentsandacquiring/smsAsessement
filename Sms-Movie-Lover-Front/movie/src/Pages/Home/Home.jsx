import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import createReactClass from 'create-react-class';
import axios from 'axios';
import ReactDOM from 'react-dom';
import NavBar from '../NavBar/NavBar';

class Home extends Component {
    constructor() {
        super();
        this.state = {
            fieldNames:
                [
                    {
                        "value": ""
                    },
                    {
                        "value": "Movie Name"
                    },
                    {
                        "value": "Movie Year"
                    },
                    {
                        "value": "Movie Genre"
                    },
                    {
                        "value": "Movie Publsher"
                    },
                    {
                        "value": "Movie Rating"
                    },
                ],
            ipAddress: "localhost",
            port: "8550"
        }
    }

    render() {
        const active = "home";
        return (
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active} />
                </div>
                <div class="watchListBody">
                    <p>
                        Welcome to the  SMS Movie Lover App, where you are able keep track of all the movie you have watched.
                    </p>
                </div>
                <div align="center" class="App-header">
                    <form id="adminTable">
                        <h1><u>All movies Watched</u></h1>
                        <div id="tableComponent">Loading...</div>
                    </form>
                </div>
            </div>
        );
    };
    componentDidMount() {
        var TableComponent = createReactClass({
            render: function () {
                let dataColumns = this.props.data.columns;

                let columnNames = this.props.data.columnNames;
                let dataRows = this.props.data.rows;
                let actions = ["Delete", "Edit"]

                var tableHeaders = (<thead>
                    <tr>
                        {dataColumns.map(function (column) {
                            return <th id="columnName">{column}</th>;
                        })}
                    </tr>
                </thead>);

                var tableBody = dataRows.map(function (row) {
                    function deleteButton(event) {
                        event.preventDefault();
                    }
                    function editButton(event) {
                        event.preventDefault();
                    }
                    return (
                        <tr>
                            {columnNames.map(function (column) {
                                return <td align="center">{row[column]}</td>;
                            })
                            }

                            {actions.map(function (column) {
                                if (column === "Delete") {
                                    return <td align="center"><button id="deleteButton" onClick={deleteButton}>Delete</button></td>
                                }
                                else if (column === "Edit") {
                                    return <td align="center"><button id="editButton" onClick={editButton}>Edit</button></td>
                                }
                            })}
                        </tr>);
                });

                return (<table id="adminTable" className="table table-bordered table-hover" width="100%">
                    {tableHeaders}
                    {tableBody}
                </table>)
            }
        });

        axios.get("http://" + this.state.ipAddress + ":"+ this.state.port + "/movie/getAllMovieWatched")
            .then(response => response.data)
            .then(data => {
                var list = [];
                Object.keys(data).map(function (key, index) {
                    let value = data[key];

                    list.push({
                        'movieName': value.movieName,
                        'movieYear': value.movieYear,
                        'movieGenre': value.movieGenre,
                        "moviePublisher": value.moviePublisher,
                        "movieRater": value.movieRater,
                        "index": index
                    });
                });

                var tableData = {
                    columns: ['Movie Name', 'Movie Year', 'Genre', 'Publisher', 'Actions'],
                    columnNames: ["movieName", "movieYear", "movieGenre", "moviePublisher"],
                    rows: list
                };

                ReactDOM.render(
                    <TableComponent data={tableData} />, document.getElementById('tableComponent'));
            })
            .catch(function (error) {
                alert("Error: " + error);
            })
    };
}
export default Home;