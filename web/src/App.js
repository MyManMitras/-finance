import React from 'react';
import LoginPage from './widgets/loginPage/loginPage';
import "./App.css";

class App extends React.Component {

  state = { allowUser: ''};

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
      
  };
  render () {
    var page = <LoginPage/>;
    if(this.state.allowUser === true){
        page = <LoginPage/>;
    }
    return (page);
  }
}

export default App;