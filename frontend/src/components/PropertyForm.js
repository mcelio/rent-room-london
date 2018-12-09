import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class PropertyForm extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.save = this.save.bind(this);
       this.handleIdChange = this.handleIdChange.bind(this);
       this.handleAddress1Change = this.handleAddress1Change.bind(this);
       this.handleAddress2Change = this.handleAddress2Change.bind(this);
       this.handleAddress3Change = this.handleAddress3Change.bind(this);
       this.handlePostcodeChange = this.handlePostcodeChange.bind(this);
       this.state = {
           id: "",
           address1: "",
           address2: "",
           address3: "",
           postcode: ""
       };
     }

     handleIdChange(e) {
        this.setState({id: e.target.value});
     }
     handleAddress1Change(e) {
        this.setState({address1: e.target.value});
     }

     handleAddress2Change(e) {
        this.setState({address2: e.target.value});
     }

     handleAddress3Change(e) {
        this.setState({address3: e.target.value});
     }

     handlePostcodeChange(e) {
        this.setState({postcode: e.target.value});
     }

    save(event) {
        event.preventDefault();
        console.log("saving property form");
        const authStr = localStorage.getItem('id_token');
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Authorization": authStr,
            "Access-Control-Request-Origin" : "*",
            "Access-Control-Allow-Credentials":"true",
            "withCredentials" : true,
        }

       const property = {
           "id": this.state.id,
           "address1": this.state.address1,
           "address2": this.state.address2,
           "address3": this.state.address3,
           "postcode": this.state.postcode
       }

        axios({
            method: "post",
            url: "http://localhost:8081/property",
            withCredentials: true,
            data: property,
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
                  <Label for="id">Id</Label>
                  <Input type="text" name="id" id="id" onChange={this.handleIdChange} placeholder="Id" />
                </FormGroup>
                <FormGroup>
                  <Label for="address1">Address 1</Label>
                  <Input type="text" name="address1" id="address1" onChange={this.handleAddress1Change} placeholder="Address 1" />
                </FormGroup>

                <FormGroup>
                  <Label for="address2">Address 2</Label>
                  <Input type="text" name="address2" id="address2" onChange={this.handleAddress2Change} placeholder="Address 2" />
                </FormGroup>

                <FormGroup>
                  <Label for="address3">Address 3</Label>
                  <Input type="text" name="address3" id="address3" onChange={this.handleAddress3Change} placeholder="Address 3" />
                </FormGroup>

                <FormGroup>
                  <Label for="postcode">Postcode</Label>
                  <Input type="text" name="postcode" id="postcode" onChange={this.handlePostcodeChange} placeholder="Postcode" />
                </FormGroup>
                <Button onClick={this.save}>Save</Button>
              </Form>
            );
        }
}

export default PropertyForm;
