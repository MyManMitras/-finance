import React from 'react';
import AppBar from 'react-toolbox/lib/app_bar/AppBar';
import Navigation from 'react-toolbox/lib/navigation/Navigation';
import Footer from '../footer/footer';
import Content from '../content/content';
import Button from 'react-toolbox/lib/button/Button';

class HomePage extends React.Component {
  render() {
    return (
      <section>
        <AppBar title={this.props.user.firm.name} >
          <Navigation type="horizontal">
            <Button icon='person' label={this.props.user.firstName} flat style={{ color: 'white' }} />
          </Navigation>
        </AppBar>
        <Content user={this.props.user} />
        <Footer />
      </section>);
  }
}

export default HomePage;