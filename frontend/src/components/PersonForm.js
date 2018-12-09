import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class PersonForm extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.save = this.save.bind(this);
       this.handleNameChange = this.handleNameChange.bind(this);
       this.handleEmailChange = this.handleEmailChange.bind(this);
       this.handlePassportChange = this.handlePassportChange.bind(this);
       this.handleTelephoneChange = this.handleTelephoneChange.bind(this);
       this.state = {
           name: "",
           email: "",
           passport: "",
           telephone: ""
       };
     }

     handleNameChange(e) {
        this.setState({name: e.target.value});
     }
     handleEmailChange(e) {
        this.setState({email: e.target.value});
     }

     handlePassportChange(e) {
        this.setState({passport: e.target.value});
     }

     handleTelephoneChange(e) {
        this.setState({telephone: e.target.value});
     }

    save(event) {
        event.preventDefault();
        console.log("saving person form");
        const authStr = localStorage.getItem('id_token');
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Authorization": authStr,
            "Access-Control-Request-Origin" : "*",
            "Access-Control-Allow-Credentials":"true",
            "withCredentials" : true,
        }

       const person = {
       "name": this.state.name,
       "email": this.state.email,
       "passport": this.state.passport,
       "telephone": this.state.telephone                     }

        axios({
            method: "post",
            url: "http://localhost:8081/person",
            withCredentials: true,
            data: store,
            headers
          }).then(function (response) {
             return Promise.resolve(response);
          }).catch(function (error) {
             console.log(error);
          });
    }

    render() {
            return (
              <Form>
                <FormGroup>
                  <Label for="name">Name</Label>
                  <Input type="text" name="name" id="name" onChange={this.handleNameChange} placeholder="Name" />
                </FormGroup>
                <FormGroup>
                  <Label for="email">Address</Label>
                  <Input type="text" name="email" id="email" onChange={this.handleEmailChange} placeholder="Email" />
                </FormGroup>

                <FormGroup>
                  <Label for="passport">Address</Label>
                  <Input type="text" name="passport" id="passport" onChange={this.handlePassportChange} placeholder="Passport Id/Number" />
                </FormGroup>

                <FormGroup>
                  <Label for="telephone">Address</Label>
                  <Input type="text" name="telephone" id="telephone" onChange={this.handleTelephoneChange} placeholder="Telephone" />
                </FormGroup>
                <Button onClick={this.saveStore }>Save</Button>
              </Form>
            );
        }
}

export default PersonForm;
