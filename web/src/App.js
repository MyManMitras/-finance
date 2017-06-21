import React from 'react';
import LoginPage from './widgets/loginPage/loginPage';
import HomePage from './widgets/homePage/homePage';
import "./App.css";

class App extends React.Component {

  state = { allowUser: '', user: {
    "firstName": "Prashanth",
    "lastName": null,
    "phoneNo": null,
    "emailId": null,
    "gender": "Male",
    "firm": {
        "name": "MMM",
        "licenseNo": null,
        "firmId": "asfasfas"
    }
}};
/*
  componentWillMount() {
    fetch('/finance/v1/user/sample',{accept: 'application/json'}).then(response=>{
      response.json().then(data=>{
        if(data.name ==='Prashanth1')
          this.setState({allowUser: true});
        console.log(data);
      });
    }, error=>{
      console.log('error: ' + error);
    });
  }; */

  login(user) {
    this.setState({allowUser: true,
      user: user
    });
  };

  render () {
    var page = <LoginPage login={this.login.bind(this)}/>;
    //if(this.state.allowUser === true){
        page = <HomePage user={this.state.user}/>;
    //}
    return (page);
  }
}

export default App;