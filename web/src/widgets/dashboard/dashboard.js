import React from 'react';
import Card from 'react-toolbox/lib/card/Card';
import CardTitle from 'react-toolbox/lib/card/CardTitle';
import FirmOverview from '../../components/firmOverview';

class Dashboard extends React.Component {
  render () {
    return (
        <div className="row">
            <div className="col-lg-8 col-sm-12 col-md-12">
                <div className="row">
                    <div className="col-lg-6 col-sm-12 col-md-6">
                        <FirmOverview firmId={this.props.user.firm.firmId}/>
                    </div>
                    <div className="col-lg-6 col-sm-12 col-md-6">
                        <Card>
                            <CardTitle title="Day Expenses"/>
                        </Card>
                    </div>
                </div>
                <div className="row">
                    <div className="col-lg-12 col-sm-12 col-md-12">
                        <Card>
                            <CardTitle title="Over Due Alerts"/>
                        </Card>
                    </div>
                </div>
            </div>
            <div className="col-lg-4 col-sm-12 col-md-12">
                <div className="row">
                    <div className="col-lg-12 col-sm-12 col-md-12">
                        <Card>
                            <CardTitle title="Bank Information"/>
                        </Card>
                    </div>
                </div>                
                <div className="row">
                    <div className="col-lg-12 col-sm-12 col-md-12">
                        <Card>
                            <CardTitle title="Staff Information"/>
                        </Card>
                    </div>
                </div>

            </div>
        </div>
    );
  }
}

export default Dashboard;