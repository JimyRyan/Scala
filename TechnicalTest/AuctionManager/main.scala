package com.guillaumemocquet

/**
  * Bidding system
  */
class AuctionManager {

    type Prices = Array[Float]
    type Offers = Map[String, Prices]

    /**
      * Order Prices
      */
    implicit object ArrayFloatOrdering extends Ordering[Prices] {
        // In my case, the 1st element is the max element
        def compare(a: Prices, b: Prices): Int = a.head.compare(b.head)
    }

    var bids:Offers = Map()

    /**
      * One buyer make a single bid
      *
      * @param buyer
      * @param price
      */
    def offer(buyer: Buyer, price: Float): Unit = {
        offers(buyer, Array(price))
    }

    /**
      * One buyer make multiple bids
      *
      * @param buyer
      * @param prices
      */
    def offers(buyer: Buyer, prices: Prices): Unit = {

        val buyerKey = buyer.name

        if (!bids.keySet.exists(_ == buyerKey)) {

            // Unknow buyer

            // Bigger big 1st
            val pricesSorted = prices.sortBy( x => - x )

            bids += buyerKey -> pricesSorted
        } else {

            // Update the buyer bids list
            val oldBuyerBids = bids
                    .filter(_._1 == buyerKey)
                    .map((b: (String, Prices)) => b._2 )
                    .head

            val newBuyerBids = oldBuyerBids ++ prices

            // Bigger big 1st
            val newBuyerBidsSorted = newBuyerBids.sortBy( x => - x )

            bids = bids.updated(buyerKey, newBuyerBidsSorted)
        }
    }

    /**
      * Get the winner buyer and the bid price
      *
      * @param minPrice
      * @return
      */
    def getWinner(minPrice:Float): Option[(String, Float)] = {

        // Find potential best buyer
        val winnerBuyerFiltered = bids
                .filter( list => list._2.head >= minPrice )

        val winnerBuyer : Option[String] = if (!winnerBuyerFiltered.isEmpty) {
            Some(winnerBuyerFiltered.maxBy(_._2)._1)
        } else {
            None
        }

        // Find potential best bid
        val buyerMaxBidFiltered = bids
                .filter( list => list._2.head >= minPrice )
                .filter( list => list._1 != winnerBuyer.get )

        val buyerMaxBid : Option[Float] = if (!buyerMaxBidFiltered.isEmpty) {
            Some(buyerMaxBidFiltered.maxBy(_._2)._2.head)
        } else {
            None
        }

        if (buyerMaxBid.isDefined && winnerBuyer.isDefined) {
            Some(winnerBuyer.get, buyerMaxBid.get)
        } else {
            None
        }
    }

}

class Buyer(val name: String) {

    override def toString(): String = {
        return "Buyer: %s".format(name)
    }

}

object Main extends App {

    val am = new AuctionManager()

    am.offers(new Buyer("A"), Array(110F, 130F))
    am.offers(new Buyer("C"), Array(125F, 20F))
    am.offers(new Buyer("D"), Array(105F, 115F, 90F))
    am.offers(new Buyer("E"), Array(132F, 135F, 140F))
    am.offer(new Buyer("C"), 1500F)
    am.offer(new Buyer("E"), 999F)

    println(am.getWinner(100F))
}