import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class BillForm extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.save = this.save.bind(this);
       this.handleDateChange = this.handleDateChange.bind(this);
       this.handleEnergyChange = this.handleEnergyChange.bind(this);
       this.handleWaterChange = this.handleWaterChange.bind(this);
       this.handleInternetChange = this.handleInternetChange.bind(this);
       this.handleTvChange = this.handleTvChange.bind(this);
       this.handleCouncilTaxChange = this.handleCouncilTaxChange.bind(this);
       this.handleAdditionalServicesChange = this.handleAdditionalServicesChange.bind(this);
       this.handlePropertyChange = this.handlePropertyChange.bind(this);
       this.handleCleanerChange = this.handleCleanerChange.bind(this);
       this.state = {
           id: "",
           date: "",
           energy: "",
           water: "",
           internet: "",
           tv: "",
           councilTax: "",
           additionalTax: "",
           property: "",
           cleaner: ""
       };
     }

     handleDateChange(e) {
        this.setState({date: e.target.value});
     }

     handleEnergyChange(e) {
        this.setState({energy: e.target.value});
     }

     handleWaterChange(e) {
        this.setState({water: e.target.value});
     }

     handleCleanerChange(e) {
        this.setState({cleaner: e.target.value});
     }

     handleCouncilTaxChange(e) {
        this.setState({councilTax: e.target.value});
     }

     handleAdditionalServicesChange(e) {
        this.setState({additionalServices: e.target.value});
     }

     handleInternetChange(e) {
        this.setState({internet: e.target.value});
     }

     handleTvChange(e) {
        this.setState({tv: e.target.value});
     }

     handlePropertyChange(e) {
        this.setState({property: e.target.value});
     }

    save(event) {
        event.preventDefault();
        console.log("saving bill form");
        const authStr = localStorage.getItem('id_token');
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Authorization": authStr,
            "Access-Control-Request-Origin" : "*",
            "Access-Control-Allow-Credentials":"true",
            "withCredentials" : true,
        }

       const bill = {
           "date": this.state.date,
           "energy": this.state.energy,
           "water": this.state.water,
           "tv": this.state.tv,
           "additionalServices": this.state.additionalServices,
           "internet": this.state.internet,
           "cleaner": this.state.cleaner,
           "councilTax": this.state.councilTax,
           "property": this.state.property
       }

        axios({
            method: "post",
            url: "http://localhost:8081/bill",
            withCredentials: true,
            data: bill,
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
                  <Label for="date">Date</Label>
                  <Input type="text" name="date" id="date" onChange={this.handleDateChange} placeholder="Date " />
                </FormGroup>

                <FormGroup>
                  <Label for="energy">Energy</Label>
                  <Input type="text" name="energy" id="energy" onChange={this.handleEnergyChange} placeholder="Energy " />
                </FormGroup>

                <FormGroup>
                  <Label for="water">Water</Label>
                  <Input type="text" name="water" id="water" onChange={this.handleWaterChange} placeholder="Water " />
                </FormGroup>

                <FormGroup>
                  <Label for="tv">TV</Label>
                  <Input type="text" name="tv" id="tv" onChange={this.handleTvChange} placeholder="TV " />
                </FormGroup>

                <FormGroup>
                  <Label for="internet">Internet</Label>
                  <Input type="text" name="internet" id="internet" onChange={this.handleInternetChange} placeholder="Internet " />
                </FormGroup>

                <FormGroup>
                  <Label for="cleaner">Cleaner</Label>
                  <Input type="text" name="cleaner" id="cleaner" onChange={this.handleCleanerChange} placeholder="Cleaner " />
                </FormGroup>

                <FormGroup>
                  <Label for="additionalServices">Additional Services</Label>
                  <Input type="text" name="additionalServices" id="additionalServices" onChange={this.handleAdditionalServicesChange} placeholder="Additional Services " />
                </FormGroup>

                <FormGroup>
                  <Label for="property">Property</Label>
                  <Input type="text" name="property" id="property" onChange={this.handlePropertyChange} placeholder="Property " />
                </FormGroup>

                <Button onClick={this.save}>Save</Button>
              </Form>
            );
        }
}

export default BillForm;
