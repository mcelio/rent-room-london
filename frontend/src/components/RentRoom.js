import React from "react";
import ReactDOM from "react-dom";
import Login from './Login';
import PropertyForm from './PropertyForm';
import PersonForm from './PropertyForm';
import ContractForm from './ContractForm';
import PaymentForm from './PaymentForm';
import BillForm from './BillForm';
import App from './App';
import 'bootstrap/dist/css/bootstrap.css';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';
import { BrowserRouter as Router, Route, Redirect, Link } from "react-router-dom";
import { NavLink as RRNavLink } from 'react-router-dom';
import AuthService from './AuthService';

const Auth = new AuthService();

class RentRoom extends React.Component {

  constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }


  componentDidMount() {
     //this.props.history.push('/map');
  }

  render() {
    return (
      <Router>
          <div>
            <Navbar color="faded" light expand="md">
              <NavbarBrand href="/">Rent Room London</NavbarBrand>
              <NavbarToggler onClick={this.toggle} />
              <Collapse isOpen={this.state.isOpen} navbar>
                <Nav className="ml-auto" navbar>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/personForm" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Person Form</NavLink>
                  </NavItem>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/propertyForm" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Property Form</NavLink>
                  </NavItem>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/contractForm" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Contract Form</NavLink>
                  </NavItem>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/paymentForm" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Payment Form</NavLink>
                  </NavItem>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/billForm" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Bill Form</NavLink>
                  </NavItem>

                  <NavItem hidden={Auth.loggedIn()}>
                    <NavLink to="/login" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Login</NavLink>
                  </NavItem>

                  <NavItem hidden={!Auth.loggedIn()}>
                    <NavLink to="/logout" activeClassName="active" onClick={this.toggle} tag={RRNavLink}>Logout</NavLink>
                  </NavItem>
                </Nav>
              </Collapse>
            </Navbar>
            <Route exact path="/personForm" render={(props) => (
                                  Auth.loggedIn() ? (
                                    <PersonForm {...props} />
                                  ) : (
                                    <Redirect to="/login"/>
                                  )
                                )}/>

             <Route exact path="/propertyForm" render={(props) => (
                                   Auth.loggedIn() ? (
                                     <PropertyForm {...props} />
                                   ) : (
                                     <Redirect to="/login"/>
                                   )
                                 )}/>

             <Route exact path="/contractForm" render={(props) => (
                                    Auth.loggedIn() ? (
                                      <ContractForm {...props} />
                                    ) : (
                                      <Redirect to="/login"/>
                                    )
                                  )}/>

             <Route exact path="/paymentForm" render={(props) => (
                                  Auth.loggedIn() ? (
                                    <PaymentForm {...props} />
                                  ) : (
                                    <Redirect to="/login"/>
                                  )
                                )}/>

             <Route exact path="/billForm" render={(props) => (
                                               Auth.loggedIn() ? (
                                                 <BillForm {...props} />
                                               ) : (
                                                 <Redirect to="/login"/>
                                               )
                                             )}/>

            <Route path="/login" component={Login} />
            <Route path="/logout"  render={(props) => (
                                Auth.logout() ? (
                                <Redirect to="/login"/> )
                                : (
                                    <Redirect to="/login"/>
                                  )
                               )}/>
         </div>   
      </Router>
    );
  }
}

export default RentRoom;




