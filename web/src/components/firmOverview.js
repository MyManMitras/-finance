import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import CardText from 'react-toolbox/lib/card/CardText';

class FirmOverview extends React.Component {

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
            <CardTitle title="Firm Overview"/>
            <CardText>
              <h6>Total customers : {this.state.overview.totalCustomers}</h6>
              <h6>Total customer lends : {this.state.overview.totalLentAmount}</h6>
              <h6>Total customer deposits: {this.state.overview.totalDeposits}</h6>
              <h6>Total cash in firm: {this.state.overview.cashInFirm}</h6>
            </CardText>
        </Card>
    );
  };
}

export default FirmOverview;