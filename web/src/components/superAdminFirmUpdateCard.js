import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import CardActions from 'react-toolbox/lib/card/CardActions';
import Button from 'react-toolbox/lib/button/Button';

class SuperAdminFirmUpdateCard extends React.Component {

  state = {overview: {}};
  componentWillMount() {
    fetch('/finance/v1/dashboard/firmOverview/'+this.props.firmId,{accept: 'application/json'}).then(response=>{
      response.json().then(data=>{
        this.setState({overview: data});
      });
    }, error=>{
      console.log('error: ' + error);
    });
  };
  render () {
    return (
        <Card>
            <CardTitle title="Firm Details"/>
            <CardActions>
                <Button label="Update Details" />
                <Button label="Cancel" />
            </CardActions>
        </Card>
    );
  };
}

export default SuperAdminFirmUpdateCard;