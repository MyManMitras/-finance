import React from 'react';
import LoginCard from '../loginCard/loginCard';
import AppBar from 'react-toolbox/lib/app_bar/AppBar';
import Footer from '../footer/footer';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';

class LoginPage extends React.Component {
  render () {
    return (<section>
        <AppBar title='M - Cube' ></AppBar>
        <div className="row">
          <div className="col-lg-9 col-sm-12 col-md-12">
            <Card>
              <CardTitle title="Pitcure/New/Updates"/>
            </Card>
          </div>
          <div className="col-lg-3 col-sm-12 col-md-12">
            <LoginCard/>
          </div>
        </div>
        <div className="row">
          <div className="col-lg-12 col-sm-12">
            <Card>
              <CardTitle title="Disclimer: "/>
            </Card>
          </div>
        </div>
        <Footer/>
      </section>);
  }
}

export default LoginPage;