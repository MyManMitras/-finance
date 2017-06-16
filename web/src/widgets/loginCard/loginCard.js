import React from 'react';
import Input from 'react-toolbox/lib/input/Input';
import Button from 'react-toolbox/lib/button/Button';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';

class LoginCard extends React.Component {

  state = { login: '', password: '', org: ''};
  handleChange = (name, value) => {
    this.setState({...this.state, [name]: value});
  };

  login = () => {
    var payload = {
      org: this.state.org,
      login: this.state.login,
      password: this.state.password
    };
    var data = new FormData();
    data.append( "json", JSON.stringify( payload ) );

    fetch('/finance/v1/login',{method: 'POST',dataType: 'json', body: JSON.stringify( payload ), accept: 'application/json',headers:{'content-type': 'application/json'}})
    .then(response=>{
      response.json().then(data=>{
        this.props.login(data);
      });
    }, error=>{
      console.log('error: ' + error);
    });
  };
 
  render () {
    return (
        <Card>
            <CardTitle title="Login Here"/>
            <section style={{padding: '14px 16px 10px'}}>
              <Input type='text' label='Organization Id' name='orgId' maxLength={9} value={this.state.org} onChange={this.handleChange.bind(this, 'org')}/>
              <Input type='text' label='Login Id' name='loginId' maxLength={9} value={this.state.login} onChange={this.handleChange.bind(this, 'login')}/>
              <Input type='password' label='Password' name='loginId' maxLength={6} value={this.state.password} onChange={this.handleChange.bind(this, 'password')}/>
              <Button label='Request Password Reset' flat primary style={{'fontSize': 'smaller'}}></Button>
              <Button label='Login' primary raised onClick={this.login.bind(this)}></Button>
            </section>
        </Card>
    );
  }
}

export default LoginCard;