package com.heromanager.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import static com.heromanager.heroesapi.constans.HeroesConstant.DYNAMO_ENDPOINT;
import static com.heromanager.heroesapi.constans.HeroesConstant.DYNAMO_REGION;

public class HeroesData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION))
        .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("HeroesTable");

        Item hero = new Item()
                .withPrimaryKey("id", 2)
                .withString("name","Wonder Woman")
                .withString("universe","DC Comics")
                .withNumber("movies",3);

        PutItemOutcome outcome = table.putItem(hero);
    }
}
