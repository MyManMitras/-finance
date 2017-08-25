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
    "role": "SuperUser",
    "firm": {
        "name": "MMM",
        "licenseNo": null,
        "firmId": "asfasfas"
    }
}};  
  login(user) {
    this.setState({allowUser: true,
      user: user
    });
  };

  render () {
    var page = <LoginPage login={this.login.bind(this)}/>;
    if(this.state.allowUser === true){
        page = <HomePage user={this.state.user}/>;
    }
    return (page);
  }
}

export default App;